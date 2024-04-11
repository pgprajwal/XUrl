
## Overview

XUrl is a utility that can be used to generate and retrieve short URLs when we don’t want to use the original longer URLs.

During the course of this project:

- Created a short url library with required methods.
- Implemented register method to take a long URL and return a shorter URL.
- Implemented a method to lookup the long URL by providing the short URL.
- Implemented hit count to track number of long URL lookups.
- Tested this implementation with test cases.

## XUrl Interface

![XUrl Image](https://github.com/pgprajwal/Personal-Archive/blob/main/images/XUrl_Interface.jpeg)

## Scope of Work

- **Concrete Class Implementation**: Implemented a concrete class that provides methods for creating long URL to short URL mappings.
- **Random Short URL Generation**: Created a method to generate a random 9-character short URL for a given long URL and maintained this mapping using a hash map for quick retrieval.
- **Custom Short URL Registration**: Implemented a method to register a custom short URL for a given long URL.
- **Error Handling**: Ensured that each long URL maps to only one short URL and vice versa.
- **Lookup Method Implementation**: Created a method to lookup short URL for a given long URL from the mapping.
- **Mapping Deletion**: Implemented a method to delete mappings based on long URLs.
- **Hit Count Implementation**: Added a counter to keep track of the hit count for each long URL, indicating how many times a particular long URL has been looked up.
- **Testing**: Rigorously tested these methods using test cases.
