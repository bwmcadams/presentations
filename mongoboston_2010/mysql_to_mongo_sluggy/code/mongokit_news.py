class NewsStory(MongoPylonsDocument):
    use_dot_notation = True
    use_autorefs = True
    collection_name = 'news'
    structure = {
        'author': AdminUser,
        'headline': unicode,
        'story': unicode,
        'start_date': datetime.datetime,
        'end_date': datetime.datetime,
        'archived': bool # default false
    }

    required_fields = ['author', 'headline', 'story', 'start_date']
    default_values = {
      'start_date': TODAY,
      'archived': False,
    }

    indexes = [
	    {
	        'fields': ['start_date', 'end_date'],
	        'ttl': 86400,
	    },        
		{
            'fields': 'archived',
            'ttl': 86400,
        }
    ]
