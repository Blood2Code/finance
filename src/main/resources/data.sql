-- 👤 Users
INSERT INTO users (id, name, email, status) VALUES
                                                            (1, 'Ali Valiyev', 'ali@example.com', 'ACTIVE'),
                                                            (2, 'Dilnoza Karimova', 'dilnoza@example.com', 'ACTIVE'),
                                                            (3, 'Bobur Yusupov', 'bobur@example.com', 'BLOCKED');

-- 💳 Cards
INSERT INTO card (id, name, balance, status, user_id, created_by, created_date, last_modified_by, last_modified_date) VALUES
                                                              (1, 'Ali Main Card', 100000.00, 'ACTIVE', 1, 'system', NOW(), 'system', NOW()),
                                                              (2, 'Dilnoza Savings', 250000.00, 'ACTIVE', 2, 'system', NOW(), 'system', NOW()),
                                                              (3, 'Bobur Card', 50000.00, 'INACTIVE', 3, 'system', NOW(), 'system', NOW());

-- 💸 Transactions
INSERT INTO transaction (id, comment, amount, status, source_card_id, destination_card_id, created_by, created_date, last_modified_by, last_modified_date) VALUES
                                                               (1, 'Transfer to Dilnoza', 10000.00, 'SUCCESS', 1, 2, 'system', NOW(), 'system', NOW()),
                                                               (2, 'Refund to Ali', 5000.00, 'REVERSED', 2, 1, 'system', NOW(), 'system', NOW()),
                                                               (3, 'Payment to Bobur', 7000.00, 'SUCCESS', 1, 3, 'system', NOW(), 'system', NOW());
