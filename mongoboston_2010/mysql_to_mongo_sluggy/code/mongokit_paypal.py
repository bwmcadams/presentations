ipn_db = None
try:
    dbh = MongoPylonsEnv.mongo_conn()\
        [MongoPylonsEnv.get_default_db()]['defenders_paypal_ipn']
    ipn_id = dbh.insert(dict(request.POST.items()), safe=True)
    ipn_db = dbh.find_one({'_id': ipn_id})
    if not ipn_db:
        raise Exception('could not lookup, post-insert')
except Exception, e:
    log.exception("Paypal IPN Error: Unable to commit IPN data to "
                  " Database: %s " % repr(e))
    raise DefendersIPNException(repr(e))
