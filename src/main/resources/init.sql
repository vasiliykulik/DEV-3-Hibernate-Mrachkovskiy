CREATE TABLE employee
(
  id           BIGINT NOT NULL,
  name         CHARACTER VARYING,
  surname      CHARACTER VARYING,
  phone_number CHARACTER VARYING,
  "position"   CHARACTER VARYING,
  salary       REAL,
  dtype CHARACTER VARYING,
  PRIMARY KEY (id)
);

CREATE TABLE dish
(
  id       BIGINT NOT NULL,
  name     CHARACTER VARYING,
  category CHARACTER VARYING,
  price    REAL,
  weight   REAL,
  PRIMARY KEY (id)
);

CREATE TABLE orders
(
  id BIGINT NOT NULL ,
  employee_id BIGINT,
  table_number INTEGER,
  order_date DATE,
  PRIMARY KEY (id),
  FOREIGN KEY (employee_id) REFERENCES employee (id)
);

CREATE TABLE dish_to_order
(
  dish_id  BIGINT NOT NULL,
  order_id BIGINT NOT NULL,
  PRIMARY KEY (dish_id, order_id),
  FOREIGN KEY (dish_id) REFERENCES dish (id),
  FOREIGN KEY (order_id) REFERENCES orders (id)
)