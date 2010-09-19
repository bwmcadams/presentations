print "Importing News Stories."
for story in meta.Session.query(NewsStory).all():
    _story = mongoModel.NewsStory(doc={
        'author': admins[story.author_id],
        'headline': story.headline,
        'story': story.story,
        'start_date': convert_date(story.start_date),
        'end_date': convert_date(story.end_date),
        'archived': story.archive
    }).save()

print "Setting up news story indices."
mongoModel.NewsStory.get_collection().\
    ensure_index('archived', direction=ASCENDING)
mongoModel.NewsStory.get_collection().\
    ensure_index([('start_date', ASCENDING), 
				  ('end_date', ASCENDING)])