# TheLookBook

An Android App that uses GoodReads API to retrieve details / data on books and their respective authors. This application is part of the Android Course Content.

## Description

Deciding what to read next? You’re in the right place. Tell the app what titles or genres you enjoy and it’ll give you surprisingly insightful recommendations.


## Getting Started

A very simple app to exemplify how to get data from the GoodReads API using http calls on the server side. It doesn't make use of the database. Once the data is received, it is "forwarded" to the client to be displayed. One can display more data if desired.

##### Prerequisites
- Android SDK
- Latest Android Build Tools
- Android Support Repository

##### Overview
The App does the following:
1. Fetch the books from the GoodReads API in JSON format
2. Deserialize the JSON data for each of the books into `Book` objects
3. Build an array of `Book` objects and create an `ArrayAdapter` for those books
4. Attach the adapter for the books to a ListView to display the data on screen



