-- =============================================
-- Workshop 1 - MyStock Database Creation Script
-- Author: MindyCoding by Tran
-- Description: Creates MyStock database with Cars table and sample data
-- =============================================

-- Create Database
IF NOT EXISTS (SELECT name FROM sys.databases WHERE name = N'MyStock')
BEGIN
    CREATE DATABASE MyStock;
    PRINT 'Database MyStock created successfully.';
END
ELSE
BEGIN
    PRINT 'Database MyStock already exists.';
END
GO

-- Use Database
USE MyStock;
GO

-- Drop existing table if exists (optional - for clean reinstall)
-- IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Cars]') AND type in (N'U'))
-- BEGIN
--     DROP TABLE [dbo].[Cars];
--     PRINT 'Existing Cars table dropped.';
-- END
-- GO

-- Create Cars Table
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Cars]') AND type in (N'U'))
BEGIN
    CREATE TABLE Cars (
        carID INT PRIMARY KEY,
        carName NVARCHAR(100) NOT NULL,
        manufacturer NVARCHAR(100) NOT NULL,
        price FLOAT NOT NULL,
        releasedYear INT NOT NULL
    );
    PRINT 'Cars table created successfully.';
END
ELSE
BEGIN
    PRINT 'Cars table already exists.';
END
GO

-- Insert Sample Data
-- Delete existing data first (optional)
DELETE FROM Cars;
GO

-- Insert sample cars
INSERT INTO Cars (carID, carName, manufacturer, price, releasedYear) VALUES
(1, 'Accord', 'Honda Motor Company', 24970.0, 2021),
(2, 'Civic 2.0', 'Honda', 34000.0, 2021),
(3, 'Clarity', 'Honda Motor Company', 33400.0, 2021),
(4, 'BMW 8 Series', 'BMW', 85000.0, 2021),
(5, 'Audi A8', 'Audi', 16000.0, 2020),
(6, 'BMW 523i', 'BMW', 100000.0, 2021),
(7, 'Camry', 'Toyota Motor Corporation', 25965.0, 2021),
(8, 'Corolla', 'Toyota Motor Corporation', 20425.0, 2021),
(9, 'Model 3', 'Tesla, Inc.', 39990.0, 2021),
(10, 'Mustang', 'Ford Motor Company', 27155.0, 2021);
GO

-- Verify data
SELECT * FROM Cars ORDER BY carID;
GO

PRINT 'Sample data inserted successfully.';
PRINT 'MyStock database setup complete!';
GO