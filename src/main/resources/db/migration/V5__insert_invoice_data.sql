-- Invoice data
INSERT INTO invoices (issue_date, due_date, deliveryDate, seller_id, buyer_id, note, paid, status) VALUES
    (CURRENT_DATE, CURRENT_DATE + 5, CURRENT_DATE + 6, 1, 1, '', false, 'open'),
    (CURRENT_DATE, CURRENT_DATE + 15, CURRENT_DATE + 23, 1, 2, 'to be paid in full', false, 'open');

-- Item data
INSERT INTO items VALUES
    -- invoice 1
    (1, 1, 'Smartphones 2.1GHz 2MB', 2, 1020.34),
    (1, 2, 'Smartphone Cases Extra Strength', 2, 35.30),
    (1, 3, 'Fast Charging Adapter v2', 1, 28.90),

    -- invoice 2
    (2, 1, 'Tree Bark Chippings (oz.)', 3, 50.4),
    (2, 2, 'Water lilly plants', 12, 4.6),
    (2, 3, 'Premium Loan Grade A', 120, 55.80),
    (2, 4, 'Plant food fertilizers', 10, 20);