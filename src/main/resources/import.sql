-- Categories
INSERT INTO backoffice_categories VALUES (1000, 'Coffee', 'Coffee');
INSERT INTO backoffice_categories VALUES (1001, 'Food', 'Food');
INSERT INTO backoffice_categories VALUES (1002, 'Soft drinks', 'Soft drinks');

-- Articles
-- Coffee
INSERT INTO backoffice_articles VALUES (2.50, 1000, 2000, 'Espresso', 'Espresso', 'ABC');
INSERT INTO backoffice_articles VALUES (3.50, 1000, 2001, 'Latte', 'Latte', 'ABC');
INSERT INTO backoffice_articles VALUES (4.00, 1000, 2002, 'Iced coffee', 'Iced coffee', 'ABC');

-- Food
INSERT INTO backoffice_articles VALUES (3.00, 1001, 2003, 'Donuts', 'Donuts', 'ABC');
INSERT INTO backoffice_articles VALUES (3.80, 1001, 2004, 'Croissant', 'Croissant', 'ABC');
INSERT INTO backoffice_articles VALUES (4.00, 1001, 2005, 'Breakfast Sandwich', 'Breakfast Sandwich', 'ABC');
INSERT INTO backoffice_articles VALUES (6.00, 1001, 2006, 'pizza', 'pizza', 'ABC');

-- Softdrinks
INSERT INTO backoffice_articles VALUES (2.80, 1002, 2007, 'Coca-Cola Classic', 'Coca-Cola Classic', 'ABC');
INSERT INTO backoffice_articles VALUES (3.20, 1002, 2008, 'Mountain Dew', 'Mountain Dew', 'ABC');
INSERT INTO backoffice_articles VALUES (2.00, 1002, 2009, 'Water', 'Water', 'ABC');

-- Tables
INSERT INTO backoffice_tables VALUES (true, 4, 3000, 'Oslo');
INSERT INTO backoffice_tables VALUES (true, 8, 3001, 'Stockholm');
INSERT INTO backoffice_tables VALUES (true, 12, 3002, 'New York');
INSERT INTO backoffice_tables VALUES (false, 4, 3003, 'Munich');
INSERT INTO backoffice_tables VALUES (true, 6, 3004, 'Barcelona');

-- Users
INSERT INTO backoffice_users(id, username, password, role) VALUES (10000, 'bob', '$2y$10$iFKr4Ev412kfvh0VTrdmi.lDdtfZP17H94vRO/aID2yMTWKMglk6K', 'admin'); -- password is admin
INSERT INTO backoffice_users(id, username, password, role) VALUES (10001, 'alice', '$2y$10$/2XvEq62kbYNjkz0/VjtYevf0j4Dy1.r5FocZjsya.aPnmI8b0DyW', 'user'); -- password is user