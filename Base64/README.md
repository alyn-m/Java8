## Why Do We Need Base64 in java 8?
 - The requirement for Base64 is to transfer binary data (like an image, an encrypted key, or a compressed file) across systems or protocols
 - 🚫 The Problem Before Java 8
    - Prior to Java 8, developers faced two main, poor choices for Base64 encoding/decoding:
    1. The Unofficial, Internal API
        - The most common solution was to use the internal, unsupported classes:
        - ```sun.misc.BASE64Encoder```
        - The severe issue: These classes were part of the sun.misc package, which is a non-standard, internal API. The Java documentation explicitly warned that these classes could be removed or changed without notice in any future Java release, breaking production code. Relying on them was a huge maintenance risk.
    2. Third-Party Libraries
        - The only official, safe alternative was to add a dependency on a third-party library, such as Apache Commons Codec.
        - The issue: While reliable, adding an external dependency for a task as common as Base64 encoding is burdensome. It increases the project's size, adds another point of potential security vulnerability, and makes the code less self-contained.
      
## Practical Use Cases Where Base64 is Essential
 1. JWTs (JSON Web Tokens):
     - The header and payload of a JWT are Base64 URL-safe encoded. This allows the JSON data to be safely transmitted as part of a URL, cookie, or HTTP header.
 2. Basic HTTP Authentication:
     - Credentials (username:password) are concatenated and then Base64 encoded before being placed in the Authorization header.
 3. Data URIs (Web Development):
     - Embedding small images or other files directly into HTML/CSS/JavaScript files. The file's binary content is first Base64 encoded.
 4. Serialization:
     - Encoding binary blobs (like cryptographic keys, digital signatures, or binary file data) before storing them in text-based storage formats (like JSON, XML, or plain-text database fields).
   
## What is base64?
 - Base64 is an encoding technique, that converts binary data into an ASCII string format.
### Pupose of base64?
 - Its primary purpose is to safely transmit binary data across mediums/protocols (like email or HTTP) that are designed to handle only text data.

## Working of base64
 - Base64 is like a secret code that lets you take any kind of computer data—like a picture, an audio file, or even an encrypted password (which are all just bytes of information)—and turn it into a string of plain text letters and numbers that computers can easily handle and send anywhere.
 - Why We Need This "Code"
    - Imagine you have a picture and you want to send it through an old email system or put it safely inside a web address (URL). These systems are only built to handle basic text (like the letters a-z, A-Z, and the numbers 0-9).
       - The Problem: If you send the raw picture data, some of the bytes might look like special control characters (like "end of file" or "new line") to the system, which can corrupt the data or break the transmission.
       - The Solution (Base64): Base64 takes the messy, raw data and converts it into a clean, safe set of 64 specific, reliable characters.
 - The 64 Characters
 - The character set used in standard Base64 consists of:
    - Uppercase letters: A–Z (26 characters)
    - Lowercase letters: a–z (26 characters)
    - Digits: 0–9 (10 characters)
    - Two symbols: + and / (2 characters)
    - Padding character: = (used for ensuring the output length is a multiple of 4)
  
 - >[!Note]
   >It's essentially a way to make binary data look like safe, transmittable text.
   
     
