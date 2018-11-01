package com.lukas.ascmdrenamer

import java.io.File
import java.io.FileNotFoundException

fun main(args: Array<String>){
    println("Type in the directory of the files you want to format:")
    val filePath:String? = readLine()
    println("Do you really want to use '${filePath}' ?(y/n)")
    if(readLine() == "y"){
        val dirFileObject = File(filePath)
        val dir:Array<File> = if (!File(filePath).exists()){
            dirFileObject.listFiles()
            throw FileNotFoundException(filePath)
        }
        else if(!File(filePath).isDirectory){
            throw IllegalArgumentException(filePath + " must be a directory")
        }
        else{
            dirFileObject.listFiles()
        }
        println("Work in progress...")
        for(file in dir){
            println("i : Renaming ${file.name}")
            if(file.extension == "ttf") file.renameTo(File(filePath + File.separator + file.name.toLowerCase().replace("-","_")))
        }
        println("Done!\n")
        main(args)
    }
    else{
        main(args)
    }
}