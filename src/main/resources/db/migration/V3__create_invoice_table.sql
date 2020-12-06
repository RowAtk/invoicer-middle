CREATE TABLE IF NOT EXISTS invoices (
    invoice_num VARCHAR(8),
    header VARCHAR(1000),
    issue_date DATE,
    due_date DATE,
    delivery_date DATE,
    sellerId INTEGER,
    buyerId INTEGER,
    note VARCHAR(255),
    paid BOOLEAN,
    status varchar(20)
);

CREATE SEQUENCE inv_seq START 2;