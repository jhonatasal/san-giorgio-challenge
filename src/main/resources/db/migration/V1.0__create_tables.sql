CREATE TABLE IF NOT EXISTS public.payment_info (
	charge_code uuid NOT NULL,
	amount numeric(19, 2) NOT NULL
);

CREATE TABLE IF NOT EXISTS public.seller_info (
	seller_code uuid NOT NULL,
	name varchar(255) NOT NULL
);