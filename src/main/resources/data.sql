INSERT INTO clientes (nome, email) VALUES ('Ana Silva', 'ana.silva@demo.com');
INSERT INTO clientes (nome, email) VALUES ('Bruno Costa', 'bruno.costa@demo.com');
INSERT INTO clientes (nome, email) VALUES ('Carla Mendes', 'carla.mendes@demo.com');

INSERT INTO produtos (nome, preco) VALUES ('Notebook Pro 14', 7499.90);
INSERT INTO produtos (nome, preco) VALUES ('Mouse Ergonomico', 199.90);
INSERT INTO produtos (nome, preco) VALUES ('Teclado Mecanico', 459.00);
INSERT INTO produtos (nome, preco) VALUES ('Monitor 27 4K', 2299.50);

INSERT INTO pedidos (cliente_id, data_pedido, valor_total) VALUES (1, DATE '2026-03-20', 7699.80);
INSERT INTO pedidos (cliente_id, data_pedido, valor_total) VALUES (2, DATE '2026-03-21', 459.00);
INSERT INTO pedidos (cliente_id, data_pedido, valor_total) VALUES (3, DATE '2026-03-22', 2299.50);
INSERT INTO pedidos (cliente_id, data_pedido, valor_total) VALUES (1, DATE '2026-03-25', 199.90);
