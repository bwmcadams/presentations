footer: ![100%](images/redhatlogo.png)
slidenumbers: true
theme: RH Presentation

[.background-color: #8F0003]
[.header: #FFFFFF, Overpass SemiBold, alignment(center), text-scale(1.5)]
# Functions as a Service with 
# Apache OpenWhisk and OpenShift
<br>
<br>
<br>
<br>

### Brendan McAdams 
#### bmcadams@redhat.com
---

# Functions as a Service 
## (aka "serverless")

- Deploy code functions easily - no server setup[^1]
	- Event Driven - respond to events by invoking functions
	- Functions are loaded and executed On Demand
	- BYO Programming Language 
	- Use a hosted platform with AWS Lambda, Red Hat Cloud Functions[^2], etc…
	- or, be adventurous: build your own OpenWhisk install!
[^1]: Once your serverless platform is running

[^2]: Red Hat's OpenShift based version of OpenWhisk

^ Lambda is perhaps the best known serverless platform

---

# Introducing Apache OpenWhisk

- Fully Open Source, Apache 2 Licensed
- Functions (Actions) are the centerpiece of your code
- Deploy on the cloud (public or private!) of your choice

---

# Introducing Apache OpenWhisk
## Functions

- Functions can be written in any supported language including Node, Java, and Python
- Use your functions for cool stuff
	- Event Triggers (e.g., call it when the contents of an S3 bucket change)
	- Chain them, composing small functions together for larger behavior

---

# OpenWhisk & Red Hat 

- Red Hat is working to improve and expand upon Apache OpenWhisk, including the integration of our software portfolio
- Recently contributed Kubernetes support upstream
	- Needed to run OpenWhisk on OpenShift
- Created templates to simplify setup of OpenWhisk on OpenShift [https://github.com/projectodd/openwhisk-openshift](https://github.com/projectodd/openwhisk-openshift)
- Working on [AMQP Feed Support for OpenWhisk](https://github.com/redhat-developer-demos/faas-tutorial/blob/messaging-demo/solutions/messaging-functions/README.adoc)

^ [https://github.com/redhat-developer-demos/faas-tutorial/blob/messaging-demo/solutions/messaging-functions/README.adoc](https://github.com/redhat-developer-demos/faas-tutorial/blob/messaging-demo/solutions/messaging-functions/README.adoc)


^ Red Hat is doing a lot of work to improve OpenWhisk and push code upstream.
^ Originally was docker only

---
# Loading OpenWhisk on OpenShift


- We provide a [template for loading OpenWhisk into OpenShift](https://github.com/projectodd/openwhisk-openshift), which installs and configures all of the components:

	```sh
	oc process -f https://git.io/openwhisk-template | oc create -f -
	```

---
# OpenWhisk Actions

- An Action is the basic unit of work with OpenWhisk, containing your function
- Actions are stateless
- Invoking an action generations an "activation id" that can be used to retrieve results
- Actions can be chained together using sequences

^ JavaScript actions can be asynchronous

---

# Sample Action
### `hello.py`

```python

def main(args):
    name = args.get('name', 'stranger')
    greeting = 'Hello ' + name + '!'
    return {'greeting': greeting}
```

---

# Sample Action
### `hello.py`

```python, [.highlight: 1,2]

def main(args):
    name = args.get('name', 'stranger')
    greeting = 'Hello ' + name + '!'
    return {'greeting': greeting}
```

---

# Sample Action
### `hello.py`

```python, [.highlight: 3,4]

def main(args):
    name = args.get('name', 'stranger')
    greeting = 'Hello ' + name + '!'
    return {'greeting': greeting}
```

---
# Creating an Action
### `hello.py`

To create an action, we need to give it a name and configure it in OpenWhisk:

```shell
$ wsk -i action create helloPy hello.py
ok: created action helloPy

```

^ Some languages like Python and Java allow packaging of multiple files with an entrypoint

---
# Invoking an Action
### `hello.py`

Once it has a name, an action can be invoked directly:

```shell
$ wsk -i action invoke --result helloPy --param name "Brendan McAdams"
{
    "greeting": "Hello Brendan McAdams!"
}
```

^ `--result` tells the `wsk` client to wait for a result, but only show the output not any additional stats etc

---
# Action Sequences
### `mungeHello`

Multiple functions can be chained together using _sequences_ where the output of a function is the input to a subsequent function[^*]. 

Let's use this function to change the input name before calling `hello`…

```python
def main(args):
    name = args.get('name', 'Nosuch Person').split(" ")
    name.reverse()
    return {'name': ", ".join(name)}
```

[^*]: Make sure your output and input parameter names match up!


^ Useful for transformations while minimizing copy and paste code

---

# Action Sequences
### `mungeHello`

Our new function just splits the input name into _"Surname, First Name"_:

```shell

$ wsk -i action invoke --result alphaName --param name "Brendan McAdams"
{
    "name": "McAdams, Brendan"
}
```

---
# Action Sequences
### `mungeHello`

To create a sequence, the individual actions must already be created. Their names are the keys for the new sequence. With this setup, `alphaName` is called first, with its output being fed to `helloPy`. The response from OpenWhisk is the output of `helloPy`.

```shell
$ wsk -i action create mungeHello --sequence alphaName,helloPy
ok: created action mungeHello
```

---
# Action Sequences
### `mungeHello`

Invoking a sequence is no different than a normal action: just call it by the sequence name:

```shell
$ wsk -i action invoke --result mungeHello --param name "Brendan McAdams"
{
    "greeting": "Hello McAdams, Brendan!"
}
```

---
# Triggers & Rules

- Triggers are channels for events
- Triggers can be linked, via _rules_, to one or more actions 
- Example - A trigger named `uploadPhoto` might, when invoked, call several actions: `nsfwFilter`, `generateThumbnail`, and `parseLocation` 
	- When the `uploadPhoto` trigger is called, the rule forwards the invocation parameters to each of the 3 linked actions.



^ The trigger is, by itself, really just a name

---
# Feeds & Packages

- OpenWhisk supports the idea of pre-packaging functionality in a _package_
- Packages bundle together Actions and Feeds, allowing us to bundle related code to deploy an event driven workflow
	- Feeds are *similar* to Triggers, but act as a stream receiving multiple event types
 	- Packages allow us to bundle together related code to easily deploy a event driven workflow
	- Prebuilt packages include support for Alarms, RSS Feeds, Kafka Integration, and more.

---
# Feeds & Packages
## Feeds

- Packages can also provide _feeds_, which configure external event sources.
- Example: OpenWhisk includes a prebuilt 'alarms' package which can let us create cron-like repeating behaviors.

```shell
wsk trigger create interval \
  --feed /whisk.system/alarms/interval \
  --param minutes 2 \
  --param trigger_payload "{\"name\":\"Odin\",\"place\":\"Asgard\"}" \
  --param stopDate "2019-01-31T23:59:00.000Z"
```

^ Where a trigger is intended as a single class of event, a feed is a bundle of them.

---
[.background-color: #8F0003]
[.header: #FFFFFF, Overpass SemiBold, alignment(center), text-scale(1.5)]

# Questions?
<br>
<br>
<br>
<br>
<br>
#### Brendan McAdams \<bmcadams@redhat.com\>



