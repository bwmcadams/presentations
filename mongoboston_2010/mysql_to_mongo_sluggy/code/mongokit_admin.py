class AdminUser(MongoPylonsDocument):
    use_autorefs = True
    use_dot_notation = True
    collection_name = 'admin_users'
    structure = {
        'username': unicode, # unique
        'password': unicode,
        'display_name': unicode,
        'email': unicode,
        'last_ip': unicode,
        'last_login_date': datetime.datetime,
        'avatar': unicode,
        'disabled': bool,
    }

    required_fields = ['username', 'password', 'email']
    default_values = {'disabled': False, 'last_login_date': datetime.datetime.now()}

    indexes = [
	    {
	     'fields': ['username', 'password'],
	     'ttl': 86400
	    },
        {
         'fields': ['password'],
         'ttl': 86400
        }
    ]
