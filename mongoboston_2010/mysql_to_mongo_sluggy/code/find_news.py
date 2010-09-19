def _get_news(date):
    news = NewsStory.all({
        'archived': False,
        'start_date': {'$lte': c._today}
    }).where('this.end_date == null || this.end_date >= new Date()').\
       sort('start_date', -1) 

    return news