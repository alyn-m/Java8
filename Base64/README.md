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
   
 5. Encode ISO20022 pain/pacs XML for logging
 6. certificate fingerprints
 7. Use Base64 when storing the original raw ACH file in DB
 8. Use Base64 to send ACH → ISO20022 transformed payload to HUB Core
 9. Base64 encode environment variables
 10. Decode Base64 logs coming from container
 11. diagnostic images
 12. PDF lab reports
 13. binary clinical documents
 14. Encode public/private key material
 15. Encode digital signatures
 16. sending image bytes
 17. transcription audio bytes
 18. embeddings as binary

   
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

<img width="1024" height="1024" alt="image" src="https://github.com/user-attachments/assets/37d55216-eb58-44c6-b2db-38be746df849" />


## Programming:
 1. Encoding (Binary to Text)  : To convert an array of bytes into a Base64 string:
     - ```import java.util.Base64;
          import java.nio.charset.StandardCharsets;

          public class Base64Example {
                public static void main(String[] args) {
                String originalData = "This is a secret message.";
                byte[] inputBytes = originalData.getBytes(StandardCharsets.UTF_8);

                // Get the standard Base64 encoder
                Base64.Encoder encoder = Base64.getEncoder();

               // Perform the encoding
               String encodedString = encoder.encodeToString(inputBytes);

               System.out.println("Original: " + originalData);
               System.out.println("Encoded:  " + encodedString);
               // Output will be something like: VGhpcyBpcyBhIHNlY3JldCBtZXNzYWdlLg==
              }
          }
       ```
  2. Decoding (Text to Binary)   :  To convert a Base64 string back into the original byte array:
      - ```
        import java.util.Base64;
        import java.nio.charset.StandardCharsets;

        public class Base64DecoderExample {
               public static void main(String[] args) {
               String encodedString = "VGhpcyBpcyBhIHNlY3JldCBtZXNzYWdlLg=="; // Example encoded string

               // Get the standard Base64 decoder
               Base64.Decoder decoder = Base64.getDecoder();

               // Perform the decoding
               byte[] decodedBytes = decoder.decode(encodedString);

               // Convert the byte array back to a string for viewing
               String decodedString = new String(decodedBytes, StandardCharsets.UTF_8);

               System.out.println("Encoded:  " + encodedString);
               System.out.println("Decoded:  " + decodedString);
               // Output: Decoded:  This is a secret message.
            }
        }
        ```


     
