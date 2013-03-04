![GoCardless Java Client Library](https://s3-eu-west-1.amazonaws.com/gocardless/images/client-lib-headers/java-lib-header.png)

The GoCardless Java client provides a simple interface to the GoCardless API.

You can sign up for a GoCardless account at [https://gocardless.com](https://gocardless.com).

### Requirements

Java 6 or later.

### Using with Maven

Add this dependency to your project's POM:

    <dependency>
      <groupId>com.gocardless</groupId>
      <artifactId>gocardless-java</artifactId>
      <version>1.1.0</version>
    </dependency>

### Using without Maven

Note that using `gocardless-java` with Maven is the officially supported and recommended method.

That said, if you want to use `gocardless-java` without Maven, just:

* Download the `jar` from [the Maven Central Repository](http://search.maven.org/#search%7Cga%7C1%7Cgocardless-java)
* Ensure the `jar` is on your classpath
* Ensure you have the various dependency `jar`s on your classpath (Apache Commons Lang, Apache Commons Codec, Apache Commons BeanUtils, Google GSON)

### Usage

Refer to the [documentation](https://gocardless.com/docs).
