Imports System
Imports System.Timers
Imports System.Drawing
Imports System.Drawing.Drawing2D
Imports System.Xml

Public Class Locker
    Inherits System.Web.UI.Page
    Dim _DoorStatus(100) As elockerDoorStatus
    Dim _LockerStatus(100) As eLockerLockStatus
    Dim _LockerTemp(100) As Integer

    Dim _LockerCount As Integer
    Dim _RoomMotion As Boolean
    Dim _RoomTemp As Integer

    Enum elockerDoorStatus
        LOCKER_DOOR_CLOSED
        LOCKER_DOOR_OPEN
        LOCKER_DOOR_STATUS_UNKNOWN
    End Enum

    Enum eLockerLockStatus
        LOCKER_LOCK_LOCKED
        LOCKER_LOCK_STATUS_UNKNOWN
        LOCKER_LOCK_UNLOCKED
    End Enum


    ReadOnly Property LockerDoorStatus(i As Integer) As elockerDoorStatus
        Get
            Return _DoorStatus(i)
        End Get
    End Property

    Function LockerLock(i As Integer, act As Action) As Boolean
        If _LockerStatus(i) = eLockerLockStatus.LOCKER_LOCK_UNLOCKED Then
            _LockerStatus(i) = eLockerLockStatus.LOCKER_LOCK_LOCKED
        End If
        LockerLock = True
    End Function

    Protected Sub LockAll_Click(sender As Object, e As EventArgs) Handles LockAll.Click
        LockLockers()
    End Sub

    Private Sub LockLockers()
        Dim _allClosed As Boolean
        Dim act As Action
        act = Nothing

        _allClosed = True
        For index As Integer = 1 To 100
            _DoorStatus(index) = LockerDoorStatus(index)
            If _DoorStatus(index) = elockerDoorStatus.LOCKER_DOOR_OPEN Then
                _allClosed = False
            End If
        Next

        If _allClosed = True Then
            For index As Integer = 1 To 100
                If _LockerStatus(index) = eLockerLockStatus.LOCKER_LOCK_UNLOCKED Then
                    Call LockerLock(index, act)
                End If
            Next
        Else
            MsgBox("There are open lockers, cannot lock them all")
        End If
    End Sub


    Protected Sub LockLeft_Click1(sender As Object, e As EventArgs) Handles LockLeft.Click
        Dim _allClosed As Boolean
        Dim act As Action
        act = Nothing

        _allClosed = True
        For index As Integer = 1 To 100 Step 2
            _DoorStatus(index) = LockerDoorStatus(index)
            If _DoorStatus(index) = elockerDoorStatus.LOCKER_DOOR_OPEN Then
                _allClosed = False
            End If
        Next

        If _allClosed = True Then
            For index As Integer = 1 To 100 Step 2
                If _LockerStatus(index) = eLockerLockStatus.LOCKER_LOCK_UNLOCKED Then
                    Call LockerLock(index, act)
                End If
            Next
        Else
            MsgBox("There are open lockers on the left side, cannot lock them all")
        End If
    End Sub

    Protected Sub LockRight_Click(sender As Object, e As EventArgs) Handles LockRight.Click
        Dim _allClosed As Boolean
        Dim act As Action
        act = Nothing

        _allClosed = True
        For index As Integer = 2 To 100 Step 2
            _DoorStatus(index) = LockerDoorStatus(index)
            If _DoorStatus(index) = elockerDoorStatus.LOCKER_DOOR_OPEN Then
                _allClosed = False
            End If
        Next

        If _allClosed = True Then
            For index As Integer = 2 To 100 Step 2
                If _LockerStatus(index) = eLockerLockStatus.LOCKER_LOCK_UNLOCKED Then
                    Call LockerLock(index, act)
                End If
            Next
        Else
            MsgBox("There are open lockers on the right side, cannot lock them all")
        End If
    End Sub


    Protected Sub Button3_Click(sender As Object, e As EventArgs) Handles Button3.Click
        Dim _minutes As String
        _minutes = InputBox("Please enter the minutes when the room has been unoccupied")
        If _minutes >= 15 Then
            LockLockers()
        End If
    End Sub

    ReadOnly Property LockerTemp(i As Integer) As Integer
        Get
            Return _LockerTemp(i)
        End Get
    End Property

    ReadOnly Property RoomTemp() As Integer
        Get
            Return _RoomTemp
        End Get
    End Property


    Protected Sub Adjust_temp()
        Dim _change As Boolean = False
        For index As Integer = 1 To 100
            _LockerTemp(index) = LockerTemp(index)
            If LockerTemp(index) - _RoomTemp > 0.1 * _RoomTemp Or LockerTemp(index) - _RoomTemp < -0.1 * _RoomTemp Then
                _change = True
            End If
        Next

        If _change = True Then
            Call MsgBox("Please adjust the thermostat.")
        End If
    End Sub

    Protected Sub Timer1_Tick(sender As Object, e As EventArgs) Handles Timer1.Tick
        Call Adjust_temp()
    End Sub


End Class

