def main(args):
    name = args.get('name', 'Nosuch Person').split(" ")
    name.reverse()
    return {'name': ", ".join(name)}
