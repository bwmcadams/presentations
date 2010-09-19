def _get_news(date):
   news = meta.Session.query(NewsStory).\
      filter(and_(NewsStory.archive==False, NewsStory.start_date<=date,
             or_(NewsStory.end_date==None, NewsStory.end_date>date)))\
             .order_by(NewsStory.start_date.desc()).all()
	return news
