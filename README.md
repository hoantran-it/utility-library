# Utility library

Utility library for Java application

## Getting Started

Fork source code to get more detail or just adding maven dependency for usage.

### Installing

Add below dependency to your maven project

```
<dependency>
    <groupId>com.github.hoantran-it.library</groupId>
    <artifactId>utility-library</artifactId>
    <version>1.0</version>
</dependency>
```

### Sample use caces

Call api to sort a list object base on property field

```
import com.github.hoantran.lib.utility.comparison.CustomComparator;
import com.github.hoantran.lib.utility.sampledata.Developer;
import com.github.hoantran.lib.utility.sampledata.SampleDataCreation;
```

```
List<Developer> devList = SampleDataCreation.createDeveloperList();
Object[] propertyId = new Object[] { "name", "experienceYears" };
boolean[] ascending = new boolean[] { false, false };
Collections.sort(devList, new CustomComparator(propertyId, ascending));
```

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

For the versions available, see the [maven repository](http://search.maven.org/#search%7Cga%7C1%7Ca%3A%22utility-library%22) or [github release](https://github.com/hoantran-it/utility-library/releases)

## Authors

* **Hoan Tran** - *Initial work* - [hoantran-it](https://github.com/hoantran-it)

See also the list of [contributors](https://github.com/hoantran-it/utility-library/graphs/contributors) who participated in this project.

## License

This project is licensed under the Apache License - see the [LICENSE.md](LICENSE.md) file for details
