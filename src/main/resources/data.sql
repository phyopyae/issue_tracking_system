CREATE TABLE issue (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    status VARCHAR(50) NOT NULL
);

--INSERT INTO issue (title, description, status) VALUES ('Issue 1', 'Description for Issue 1', 'OPEN');
--INSERT INTO issue (title, description, status) VALUES ('Issue 2', 'Description for Issue 2', 'IN_PROGRESS');
