package com.sasank.communicationbetweenfragments

import android.app.backup.BackupDataInput

interface Communicator {
    fun passDataCom(editTextInput: String){}
}