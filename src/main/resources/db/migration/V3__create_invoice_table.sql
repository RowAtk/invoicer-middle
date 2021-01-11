CREATE TABLE IF NOT EXISTS invoices (
    invoice_num SERIAL,
    issue_date DATE,
    due_date DATE,
    delivery_date DATE,
    sellerId INTEGER,
    buyerId INTEGER,
    note VARCHAR(255),
    paid BOOLEAN,
    status varchar(20),
    PRIMARY KEY(invoice_num)
);

-- ITEMS
CREATE TABLE IF NOT EXISTS items (
    item_id INTEGER,
    invoice_num INTEGER,
    description VARCHAR(255),
    quantity DECIMAL,
    unit_price DECIMAL,
    PRIMARY KEY(item_id, invoice_num),
    FOREIGN KEY (invoice_num) REFERENCES invoices(invoice_num) ON DELETE CASCADE
);