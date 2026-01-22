create table users (
                       id uuid primary key,
                       email text not null unique,
                       password_hash text not null,
                       role text not null,
                       created_at timestamptz not null default now()
);

create table tickets (
                         id uuid primary key,
                         subject text not null,
                         body text not null,
                         customer_email text,
                         status text not null,
                         category text,
                         priority text,
                         sentiment text,
                         assignee_user_id uuid references users(id),
                         created_at timestamptz not null default now(),
                         updated_at timestamptz not null default now()
);

create index idx_tickets_status_created on tickets(status, created_at desc);
create index idx_tickets_assignee_status on tickets(assignee_user_id, status);

create table ticket_actions (
                                id uuid primary key,
                                ticket_id uuid not null references tickets(id),
                                actor_user_id uuid references users(id),
                                action_type text not null,
                                metadata jsonb not null default '{}'::jsonb,
                                created_at timestamptz not null default now()
);
