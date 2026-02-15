# Strategy Hub – Backend Architecture

## Overview

Strategy Hub is a SaaS platform that generates adaptive social media strategies for creators.

A creator can be:
- An athlete
- A coach
- An entrepreneur
- A content creator
- Any individual aiming to improve their online presence

This backend is the single source of truth for:

- Creator state
- Strategy generation
- AI orchestration
- Interaction tracking
- Business rules
- Security
- Persistence

Frontend: Next.js  
Backend: Spring Boot (Java 17)  
Database: PostgreSQL

The LLM is treated as a stateless function.  
All context assembly and validation occur inside this backend.

---

# Architectural Principles

1. The backend owns all business logic.
2. The frontend never calls AI directly.
3. No business logic lives inside prompts.
4. Prompts are versioned templates.
5. Creator state evolves via structured events.
6. This is a modular monolith (not microservices).
7. No external workflow engines in this phase.
8. Strategies are immutable and versioned.

---

# High-Level System Flow

Next.js → Spring Boot API → PostgreSQL  
↓  
LLM Provider

---

# Core Domain Model

## Creator

Represents a user of the platform.

Fields:
- id (UUID)
- email
- niche (e.g. sports, business, fitness, music)
- level (beginner, intermediate, advanced)
- goals (text or structured JSON)
- createdAt
- updatedAt

A creator has one evolving CreatorState.

---

## CreatorState

Represents evolving signals that influence strategy generation.

Fields:
- creatorId
- consistencyScore
- confidenceLevel
- fatigueScore
- engagementTrend
- lastStrategyDate
- metadata (JSONB)

This is mutable and updated through interaction events.

CreatorState must not be updated directly from controllers.
All updates go through domain services.

---

## Strategy

Versioned AI-generated strategy for a creator.

Fields:
- id (UUID)
- creatorId
- version (integer)
- generatedAt
- content (structured JSON)
- status (ACTIVE, ARCHIVED)

Strategies are immutable once created.
Only one strategy can be ACTIVE at a time.

---

## InteractionEvent

Represents structured events that affect creator state.

Examples:
- Performance metrics update
- Creator feedback
- Admin note
- Missed posting schedule
- Growth spike

Fields:
- id
- creatorId
- type
- payload (JSONB)
- createdAt

InteractionEvents are append-only.

---

## PromptTemplate

Versioned configuration for AI prompts.

Fields:
- id
- name
- version
- systemPrompt
- instructionTemplate
- outputSchema
- createdAt

Prompt templates are static.
They do not contain creator-specific information.

---

# AI Architecture

The LLM is treated as a stateless reasoning engine.

The backend assembles prompt context using:

- PromptTemplate
- Creator
- CreatorState
- Recent InteractionEvents (summarized)

The LLM returns structured JSON.
The backend validates and persists the result.

No chat history is stored.
No business rules are embedded in prompt text.

---

# Package Structure

com.strategyhub
├── creator
├── strategy
├── interaction
├── prompt
├── security
├── ai
└── common

Each module contains:
- Entity
- Repository
- Service
- Controller (if applicable)

Controllers must remain thin.
Business logic belongs in services.

---

# Background Processing

Background jobs are handled internally using:

- @Scheduled tasks
- Async executors
- Domain services

Examples:
- Weekly strategy refresh
- Performance evaluation
- Admin-triggered regeneration

No external automation engine is used at this stage.

---

# Security Model

- Spring Security with JWT
- Role-based access control (ADMIN, CREATOR)
- HTTPS required
- Secrets via environment variables
- Database encryption at rest (in production)

---

# Design Constraints

- Entities are not DTOs
- No bidirectional relationships by default
- Transactions at service layer
- JSONB used for flexible state only
- Controllers contain no domain logic
- AI integration isolated in ai module

---

# Scalability Goals

This architecture supports:

- Growth to thousands of creators
- Versioned strategies
- Multi-tenant support
- Controlled AI cost
- Incremental feature expansion

The system is intentionally simple.
Complexity is introduced only when scale requires it.
