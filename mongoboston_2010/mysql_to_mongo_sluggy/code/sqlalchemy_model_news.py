class NewsStory(ORMObject):
    pass

t_news = Table('news', meta.metadata,
    Column('id', Integer, primary_key=True),
    Column('author_id', Integer, ForeignKey('admin_users.id'), nullable=False),
    Column('start_date', Date, nullable=False),
    Column('end_date', Date),
    Column('headline', Unicode(255), nullable=False),
    Column('story', Unicode, nullable=False),
    Column('archive', Boolean, default=False),
    mysql_engine='InnoDB'
)

mapper(NewsStory, t_news, properties={
    'author': relation(AdminUser, backref='news_stories')
})
