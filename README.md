# Overview

For this software once run it welcomes you to it and then immediately drops the user into a consol menu system. If the users selects option 1 the user is then able to store usernames and passwords based on the place of use for them. This information is then encrypted and stored in a text file for later additions or reference. If the user uses option 2 then user is promted to provide the master password (a tempory one created and noted at the top of the code). Upon recieving the password the software decrypts the text file information and displays the content of the screen for the user to see. If the user seleccts option 3 the user is then asked whatplace of use the password they want to change is. They are then once again prompted for the master password and the program decrypts the data storage file, loads the data into objects, finds the password and replaces it, and lastly rewrites the whole file with the new objects. Lastly, if the user selects option 4 it closes the program.

My purpose in writing this software was for two main things: learn kotlin basics and learn about data encryption. I can't help but say Kotlin is fun (pun for the coding) to use. It requires a bit higher level of thinking than some other languages. As for data encryption there is a lot to it and I have lots more to learn as can be seen with the program and from my notes on future work. With that in mind data encryption is absolutely key in so many things we do it is crucial that we take time and learn some of the basics like this program has taught me. 

Follow the link below to see the code in action:
[Software Demo Video](https://youtu.be/bB52k7Z3s0o)

# Development Environment

For this project I used the Intellij Idea Software and the Java Development Kit. In order to use the Intellij Software I registed as a student for sort term use. I then also used Visual Stuio Code to edit the Readme file. Github for sharing. OBS Studio for video recording. Youtube.com for video sharing.

For this Project I used Kotlin to program it. Kotlin allows the incorporation of Java.
- java.io.File: This Library allows for the importing and exporting of file data (.txt for this program).
- javax.crypto.Cipher: This Library gives the ability of cryptographic cipher for encryption and decryption.
- javax.crypto.spec.SecretKeySpec: This Library specifies a screte key. This allows the use of byte array.
- java.util.Scanner: This Library is used to get user input on the console line.

# Useful Websites

Here is a list of useful sights and references for this project

- [Intellij Idea](https://www.jetbrains.com/idea/)
- [Oracle](https://www.oracle.com/java/technologies/downloads/)
- [Code Cademy](https://www.codecademy.com/resources/docs/kotlin/comments)
- [W3 Schools](https://www.w3schools.com/kotlin/kotlin_getstarted.php)
- [Kotlin](https://kotlinlang.org/docs/basic-syntax.html)
- [Stack Exchange](https://security.stackexchange.com/questions/45318/how-long-in-letters-are-encryption-keys-for-aes)
- [Android Developers](https://developer.android.com/reference/javax/crypto/Cipher)
- [Android Developers](https://developer.android.com/reference/javax/crypto/spec/SecretKeySpec)
- [W3 Schools](https://www.w3schools.com/java/java_user_input.asp)
- [Geeks for Geeks](https://www.geeksforgeeks.org/file-class-in-java/)
- [Youtube](https://www.youtube.com/watch?v=F9UC9DY-vIU&ab_channel=freeCodeCamp.org)

# Future Work

- Encryption/Decryption: I need to figure out why it is adding unidentifyable characters to the begining of additional places of use.
- Read/Write Errors: I need to investigate why at times when one adds new passwords to the file the file is not updated to reflect it.
- User Enviroment: It would be nicer to have a more user friendly enviroment.
- Password Storage: In the future I think it would be good to change the save file from txt to some custom format to make it less readable by thirdparties
- Master Password: Maybe during first time setup of the software allow the user to create their own password and define the criteria for doing so.
- User Accounts: Having multiple user accounts could be nice and then less use of master password input would be required.