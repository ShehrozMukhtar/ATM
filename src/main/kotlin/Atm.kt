import kotlin.system.exitProcess

data class User(
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String,
    var amount: Int = 0
)

var message: String? = null
val users = mutableListOf<User>()

fun clearScreen() {
    print("\u001b[H\u001b[2J")
}

fun main() {

    while (true) {
        clearScreen()

        if (message == null) {
            println("Welcome to ATM!")
            println("How May I help you?")
        } else {
            println("\n")
            println(message)
            message = null
            println("\n")
        }
        println("----------------------------------------------------")
        println("1. REGISTER ACCOUNT")
        println("2. LOGIN")
        println("3. QUIT")
        println("----------------------------------------------------")
        print("Enter Selection: ")
        val choice = readln()
        clearScreen()

        if (choice == "1") {
            println("Lets Create Your Account")
            println("----------------------------------------------------")
            print("Enter First Name:")
            val firstName = readln()
            print("Enter Last Name:")
            val lastName = readln()
            print("Enter Email:")
            val email = readln()
            print("Enter Password:")
            val password = readln()
            print("Enter Initial Amount: ")
            val initialAmount = readln().toInt()

            if (!email.contains("@")) {
                message = "Enter a Valid Email!"
            } else {
                users.add(User(
                    firstName = firstName,
                    lastName = lastName,
                    email = email,
                    password = password,
                    amount = initialAmount
                ))
                message = "Account Created Successfully!"
            }
        } else if (choice == "2") {
            println("Lets get You SigIn")
            println("----------------------------------------------------")
            print("Enter Email: ")
            val email = readln()
            print("Enter Password: ")
            val password = readln()

            var userIndex: Int = -1

            for (i in users.indices) {
                if (users[i].email == email) {
                    userIndex = i
                    break
                }
            }

            if (userIndex == -1) {
                message = "No Account Found!"
                continue
            }

            if (users[userIndex].password != password) {
                message = "Invalid Password"
                continue
            }

            while (true) {
                clearScreen()
                if (message == null) {
                    println("Welcome MR. ${users[userIndex].firstName} ${users[userIndex].lastName}")
                    println("How Can I Assist You Today!")
                } else {
                    println("\n")
                    println(message)
                    message = null
                    println("\n")
                }
                println("----------------------------------------------------")
                println("1.Deposit Amount")
                println("2.WithDraw Amount")
                println("3.Check Balance")
                println("4.Send Amount")
                println("5.Log Out")
                println("----------------------------------------------------")
                print("Enter Selection")
                val choice = readln()
                clearScreen()

                if (choice == "1") {
                    println("Enter Amount to Deposit")
                    val amount = readln().toInt()
                    users[userIndex].amount += amount
                    message = "Rs ${amount} has been deposited into your account!\nYour New Balance is ${users[userIndex].amount}"
                } else if (choice == "2") {
                    println("Enter Amount to Withdraw")
                    val amount = readln().toInt()
                    users[userIndex].amount -= amount
                    message = "Rs ${amount} has been withdrawn from your account!\nYour New Balance is ${users[userIndex].amount}"
                } else if (choice == "3") {
                    message = "Your Current Balance is ${users[userIndex].amount}"
                } else if (choice == "4") {
                    println("Let's Send the money")
                    println("---------------------------------------")
                    print("Enter Recipient Email: ")
                    val recipientEmail = readln()
                    print("Enter Amount to Send: ")
                    val amountToSend = readln().toInt()

                    var recipientIndex = -1

                    for (i in users.indices) {
                        if (users[i].email == recipientEmail) {
                            recipientIndex  = i
                            break
                        }
                    }

                    if (recipientIndex == -1) {
                        message = "No Account Found With Provided Email!"
                        continue
                    }

                    if (users[userIndex].amount < amountToSend) {
                        message = "Insufficient Balance\nThe requested amount to ... exceeds your balance"
                        continue
                    }

                    clearScreen()
                    println("Confirm Transaction")
                    println("Your'e Sending Rs. ${amountToSend} to ${users[recipientIndex].firstName} ${users[recipientIndex].lastName}")
                    println("---------------------------------------")
                    print("Enter your password to continue [Password/N]: ")
                    val confirmationPassword = readln()

                    if (users[userIndex].password == "N") {
                        message = "Trx Cancelled"
                        continue
                    }

                    if (users[userIndex].password != confirmationPassword) {
                        message = "Invalid Password"
                        continue
                    }

                    users[userIndex].amount -= amountToSend
                    users[recipientIndex].amount += amountToSend

                    message = "Rs. ${amountToSend} has been Successfully sent to ${users[recipientIndex].firstName} ${users[recipientIndex].lastName}\nYour Remaining Balance is ${users[userIndex].amount}"
                } else if (choice == "5") {
                    message = "Logout Success!"
                    break
                }
            }

//           if (findEmail){
//               for(j in y){
//                   if(mEmail == j.toString()){
//                       findPass = true
//                   }
//               }
//               if (findPass){
//                   print("\u001b[H\u001b[2J")
//                   println("You have SucessFully Login In")
//                   println("Welcome MR. " + credential.last().names)
//                   println("How Can I Assit You Today!")
//                   while(true){
//                       case2(true)
//                       if(b == "1"){
//                           println("Lets Add Cash")
//                           println("-------------------------------")
//                           print("\u001b[H\u001b[2J")
//                           println("Enter Amount to Deposit")
//                           amount = readln().toInt()
//                           print("\u001b[H\u001b[2J")
//                           initialAmount = amount + initialAmount
//                           println("Rs . $amount was added to your account and Your new Balance is $initialAmount")
//                       }else if(b == "2"){
//                           println("Let's Get the CashOut")
//                           println("--------------------------------------------")
//                           println("Enter Amount to With draw:")
//                           var with = readln().toInt()
//                           initialAmount = initialAmount - with
//                           println("Rs. $with was successfully with draw from your account and your new balance is RS. $initialAmount")
//
//                       }else if(b == "3"){
//                           println("Your Current Balance is $initialAmount")
//                       }else if(b == "4"){
//}else if(b == "5"){
//                           println("You have Successfully Log Out")
//                           break
//                       }else{
//
//                       }
//                   }
//
//               }else{
//                   print("\u001b[H\u001b[2J")
//                   println("Wrong Password")
//               }
//           }else{
//               print("\u001b[H\u001b[2J")
//            println("Wrong Email!")
//           }
//

        } else if (choice == "3") {
            println("Thanks For Using ")
            println("Tata! Bye! Bye!")
            break
        }

    }
//    var y = credential[0].passwords
//    var x = credential[0].emails
//
//    while (true){
//       case(true)
//       if (a =="1"){
//           if (email.contains("@gmail.com")){
//               print("3.Enter Password:")
//               var password = readln()
//               if (password.length == 8){
//                   var hasNumber       = false
//                   var hasUpperCase    = false
//                   var hasLowerCase    = false
//                   var hasSpecialChar  = false
//                   for(i in password.indices){
//                       if (password[i].isUpperCase()){
//                           hasUpperCase = true
//                           break
//                       }
//                   }
//                   for(i in password.indices){
//                       if (password[i].isLowerCase()){
//                           hasLowerCase = true
//                           break
//                       }
//                   }
//                   for(i in password.indices){
//                       if (password[i].isDigit()){
//                           hasNumber = true
//                           break
//                       }
//                   }
//                   for(i in password.indices){
//                       if (!password[i].isLetterOrDigit()){
//                           hasSpecialChar = true
//                           break
//                       }
//                   }
//
//                   if (hasNumber && hasUpperCase && hasLowerCase && hasLowerCase &&hasSpecialChar){
//                       print("3.Enter Initial Amount:")
//                        initialAmount = readln().toInt()
//                       if(initialAmount<0){
//                           println("Add Initial Amount Again")
//                           initialAmount = readln().toInt()
//                           if (initialAmount<0){
//                               println("Add Initial Amount Again")
//                               initialAmount = readln().toInt()
//                               if (initialAmount<0){
//                                   println("Account Not Created")
//                               }else{
//                                   print("\u001b[H\u001b[2J")
//                                   var user = Users(
//                                       names = name,
//                                       lastnames = lastName,
//                                       emails = email,
//                                       passwords = password,
//                                       amounts = initialAmount
//                                   )
//                                   credential.add(user)
//                                   println("You have successfully created your account!")
//                               }
//                           }else{
//                               print("\u001b[H\u001b[2J")
//                               var user = Users(
//                                   names = name,
//                                   lastnames = lastName,
//                                   emails = email,
//                                   passwords = password,
//                                   amounts = initialAmount
//                               )
//                               credential.add(user)
//                               println("You have successfully created your account!")
//                           }
//                       }else {
//                           print("\u001b[H\u001b[2J")
//                           var user = Users(
//                               names = name,
//                               lastnames = lastName,
//                               emails = email,
//                               passwords = password,
//                               amounts = initialAmount
//                           )
//                           credential.add(user)
//                           println("You have successfully created your account!")
//                       }
//                   }else{
//                       print("\u001b[H\u001b[2J")
//                       println("Password Must Contain Capital Letter Small Letter,Digit and a Special Character ")
//                   }
//               }else{
//                   print("\u001b[H\u001b[2J")
//                   println("Password Length Must be 8")
//               }
//
//           }else {
//               print("\u001b[H\u001b[2J")
//               println("Enter Valid Email!")
//           }
//       }else if (a =="2"){
}
//       else if (a == "3"){
//           println("Thanks For Using ")
//           println("Tata! Bye! Bye!")
//           exitProcess(0)
//       }else{
//           println("Wrong Selection")
//       }
//
//   }
//
//

//fun case(f: Boolean) {
//
//        println("----------------------------------------------------")
//        println("1.Register Account")
//        println("2.Login")
//        println("3.Quite")
//        println("----------------------------------------------------")
//        println("Enter Selection")
//        a = readln()
//       print("\u001b[H\u001b[2J")
//
//}
//fun case2(d:Boolean){
//}
//
