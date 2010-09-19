class AdminUser(ORMObject):
    pass

t_admin_users = Table('admin_users', meta.metadata,
    Column('id', Integer, primary_key=True),
    Column('username', Unicode(45), nullable=False, unique=True),
    Column('password', Unicode(32), nullable=False),
    Column('display_name', Unicode(64)), # Should be unique?   
    Column('email', Unicode(255), nullable=False, unique=True),
    Column('last_ip', IPV4Address, nullable=True),
    Column('last_login_date', MSTimeStamp, nullable=False),
    Column('avatar', Unicode(255), nullable=True),
    Column('disabled', Boolean, default=False),
    mysql_engine='InnoDB'
)

mapper(AdminUser, t_admin_users)