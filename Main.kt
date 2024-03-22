/*
PassTrack
CSE 310 Class
13 March 2024
Christopher Slack
Master Password for example: "Testforcalsschrisslack1!"
*/

import java.io.File
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec
import java.util.Scanner

// This creates a password information class
class Pass2Store(val place: String, val username: String, var password: String)

// This encrypts the information provided
fun encrypt(input: String, password: String): ByteArray
{
    val c = Cipher.getInstance("AES")
    val skc = SecretKeySpec(password.toByteArray(), "AES")
    c.init(Cipher.ENCRYPT_MODE, skc)
    return c.doFinal(input.toByteArray())
}

// This is what decrypts the information
fun decrypt(input: ByteArray, password: String): String
{
    val c = Cipher.getInstance("AES")
    val skc = SecretKeySpec(password.toByteArray(), "AES")
    c.init(Cipher.DECRYPT_MODE, skc)
    val decrypted = c.doFinal(input)
    return String(decrypted).trim()
}

// THis appends the information provided by user to an existing file for later reference
fun appendToFile(file: File, data: ByteArray)
{
    file.appendBytes(data)
}

// THis writes a new file with the information provided by user for later reference
fun writeToFile(file: File, data: ByteArray)
{
    file.writeBytes(data)
}

// This reads the file created
fun readFromFile(file: File): ByteArray
{
    return file.readBytes()
}

// This main part of the program that controls user interface and calls on other functions and classes
fun main()
{
    val scanner = Scanner(System.`in`)
    println("")
    println("   Welcome to Pass Track!  ")
    println("Your password manager solution!")
    println("")

    // This is a loop to keep the user in the program till they decide to exit
    while (true) {
        println("What would you like to do?")
        println("1. Store a new password")
        println("2. See your passwords")
        println("3. Edit a password")
        println("4. Exit")

        when (scanner.nextLine()) {

            // This collects user information and then encrypts and stores it
            "1" -> {
                println("Please enter the Place of Use:")
                val placeOfUse = scanner.nextLine()
                println("Please enter the Username:")
                val username = scanner.nextLine()
                println("Please enter the Password:")
                val password = scanner.nextLine()

                val masterPassword = "Testforcalsschrisslack1!"
                val pass2Store = Pass2Store(placeOfUse, username, password)
                val accountInfo = "${pass2Store.place},${pass2Store.username},${pass2Store.password}\n"
                val encrypted = encrypt(accountInfo, masterPassword)
                appendToFile(File("passwords.txt"), encrypted)
            }

            // This gets the users master Password then displays the stored info
            "2" -> {
                // Look into other potential fixes to hide this password when typed
                println("Please enter your master password:")
                val masterPassword = scanner.nextLine()
                val encrypted = readFromFile(File("passwords.txt"))
                val decrypted = decrypt(encrypted, masterPassword)
                val passwords = decrypted.split("\n")
                for (password in passwords) {
                    val parts = password.split(",")
                    if (parts.size == 3) {
                        val pass2Store = Pass2Store(parts[0], parts[1], parts[2])
                        println("Place of Use: ${pass2Store.place}      Username: ${pass2Store.username}         Password: ${pass2Store.password}")
                    }
                }
            }

            // This code allows the user to change the password a desired place of use
            "3" -> {
                println("Please enter the Place of Use for the password you want to edit:")
                val placeOfUse = scanner.nextLine()
                println("Please enter your master password:")
                val masterPassword = scanner.nextLine()
                val encrypted = readFromFile(File("passwords.txt"))
                val decrypted = decrypt(encrypted, masterPassword)
                val passwords = decrypted.split("\n").map { it.split(",") }.filter { it.size == 3 }.map { Pass2Store(it[0], it[1], it[2]) }
                for (pass2Store in passwords) {
                    if (pass2Store.place == placeOfUse) {
                        println("Please enter the new password:")
                        val newPassword = scanner.nextLine()
                        pass2Store.password = newPassword
                    }
                }

                val updatedPasswords = passwords.joinToString("\n") { "${it.place},${it.username},${it.password}" }
                val updatedEncrypted = encrypt(updatedPasswords, masterPassword)
                writeToFile(File("passwords.txt"), updatedEncrypted)
            }

            // This exits the program
            "4" -> {
                println("Thank you. Exiting...")
                return
            }

            else -> println("Invalid option. Please Enter a number between 1 and 4:")
        }
    }
}