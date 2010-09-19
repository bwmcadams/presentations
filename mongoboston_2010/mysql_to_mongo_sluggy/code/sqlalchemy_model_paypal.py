class PaypalIPN(ORMObject):
    pass


t_paypal_ipn = Table('paypal_ipn', meta.metadata,
    Column('id', Integer, primary_key=True),
    Column('first_name', Unicode(64)),
    Column('last_name', Unicode(64)),
    Column('payer_business_name', Unicode(127)),
    Column('payer_email', Unicode(127)),
    Column('payer_id', Unicode(13)),
    Column('payer_status', Unicode(10)),
    Column('residence_country', Unicode(2)),
    Column('business', Unicode(127)),
    Column('receiver_email', Unicode(127)),
    Column('receiver_id', Unicode(13)),
    Column('item_name', Unicode(127)),
    Column('item_number', Unicode(127)),
    Column('quantity', Integer),
    Column('payment_date', Unicode(127)),
    Column('payment_status', Unicode(20)),
    Column('payment_type', Unicode(10)),
    Column('pending_reason', Unicode(20)),
    Column('reason_code', Unicode(20)),
    Column('mc_currency', Unicode(127)),
    Column('mc_fee', Unicode(127)),
    Column('mc_gross', Unicode(127)),
    Column('txn_id', Unicode(17)),
    Column('address_name', Unicode(255)),
    Column('address_street', Unicode(255)),
    Column('address_city', Unicode(255)),
    Column('address_state', Unicode(255)),
    Column('address_zip', Unicode(255)),
    Column('address_country', Unicode(255)),
    Column('address_country_code', Unicode(255)),
    Column('address_status', Unicode(15)),
    Column('notes', Unicode(255), nullable=True),
    mysql_engine='InnoDB'
)

mapper(PaypalIPN, t_paypal_ipn)

