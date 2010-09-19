db = mongoModel.AdminUser._get_connection()
conn = db.connection()
conn.drop_database('emergencyPants')

admins = {}
for user in meta.Session.query(AdminUser).all():
    _admin = mongoModel.AdminUser(doc={
        'username': user.username,
        'password': user.password,
        'avatar': user.avatar,
        'disabled': user.disabled,
        'display_name': user.display_name,
        'email': user.email,
        'last_ip': unicode(user.last_ip),
        'last_login_date': user.last_login_date,
    }).save()
    admins[user.id] = _admin

mongoModel.AdminUser.get_collection().ensure_index('password',
 		 	direction=ASCENDING, unique=True)
mongoModel.AdminUser.get_collection().ensure_index(
			[('username', ASCENDING), 
			('password', ASCENDING)]) 
