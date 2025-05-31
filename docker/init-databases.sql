-- =============================================
-- SOMS Database Initialization Script
-- =============================================

-- Create separate databases for each service
CREATE DATABASE soms_users;
CREATE DATABASE soms_products;
CREATE DATABASE soms_orders;
CREATE DATABASE soms_inventory;
CREATE DATABASE soms_notifications;
CREATE DATABASE soms_shipping;

-- Grant all privileges to soms_user for each database
GRANT ALL PRIVILEGES ON DATABASE soms_users TO soms_user;
GRANT ALL PRIVILEGES ON DATABASE soms_products TO soms_user;
GRANT ALL PRIVILEGES ON DATABASE soms_orders TO soms_user;
GRANT ALL PRIVILEGES ON DATABASE soms_inventory TO soms_user;
GRANT ALL PRIVILEGES ON DATABASE soms_notifications TO soms_user;
GRANT ALL PRIVILEGES ON DATABASE soms_shipping TO soms_user;

-- Connect to each database and create schema if needed
\c soms_users;
CREATE SCHEMA IF NOT EXISTS public;
GRANT ALL ON SCHEMA public TO soms_user;

\c soms_products;
CREATE SCHEMA IF NOT EXISTS public;
GRANT ALL ON SCHEMA public TO soms_user;

\c soms_orders;
CREATE SCHEMA IF NOT EXISTS public;
GRANT ALL ON SCHEMA public TO soms_user;

\c soms_inventory;
CREATE SCHEMA IF NOT EXISTS public;
GRANT ALL ON SCHEMA public TO soms_user;

\c soms_notifications;
CREATE SCHEMA IF NOT EXISTS public;
GRANT ALL ON SCHEMA public TO soms_user;

\c soms_shipping;
CREATE SCHEMA IF NOT EXISTS public;
GRANT ALL ON SCHEMA public TO soms_user;