CREATE TABLE IF NOT EXISTS invoices (
    invoice_num SERIAL,
    header VARCHAR(1000),
    issue_date DATE,
    due_date DATE,
    delivery_date DATE,
    sellerId INTEGER,
    buyerId INTEGER,
    note VARCHAR(255),
    paid BOOLEAN,
    status varchar(20),
    primary key(invoice_num)
);

-- ITEMS
CREATE TABLE IF NOT EXISTS items (
    item_id SERIAL,
    invoice_num VARCHAR(8),
    description VARCHAR(255),
    quantity DECIMAL,
    unit_price DECIMAL
);