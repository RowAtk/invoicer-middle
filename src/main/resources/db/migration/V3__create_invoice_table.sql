CREATE TABLE IF NOT EXISTS invoices (
    invoice_num SERIAL,
    issue_date DATE,
    due_date DATE,
    delivery_date DATE,
    seller_id INTEGER,
    buyer_id INTEGER,
    note VARCHAR(255),
    paid BOOLEAN,
    status varchar(20),
    PRIMARY KEY(invoice_num),
    FOREIGN KEY(seller_id) REFERENCES sellers(id) ON DELETE RESTRICT,
    FOREIGN KEY(buyer_id) REFERENCES buyers(id) ON DELETE RESTRICT
);

-- ITEMS
CREATE TABLE IF NOT EXISTS items (
    invoice_num INTEGER,
    item_id INTEGER,
    description VARCHAR(255),
    quantity DECIMAL,
    unit_price DECIMAL,
    PRIMARY KEY(item_id, invoice_num),
    FOREIGN KEY (invoice_num) REFERENCES invoices(invoice_num) ON DELETE CASCADE
);