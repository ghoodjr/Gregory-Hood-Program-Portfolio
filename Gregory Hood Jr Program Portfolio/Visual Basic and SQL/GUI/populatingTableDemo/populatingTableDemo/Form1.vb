Imports MySql.Data
Imports MySql.Data.MySqlClient
Imports System.IO

Public Class Form1
    Dim dbCon As MySqlConnection
    Dim strQuery As String = ""
    Dim SQLCMD As MySqlCommand
    Dim dataFile As StreamReader = File.OpenText("Receipts(1).txt")

    Private Sub btnAction_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnAction.Click
        openConnection()

        Dim num As Integer = 500

        Do While dataFile.Peek <> -1

            Dim strLine As String = dataFile.ReadLine()

            If strLine = "" Then
                num += 1

            Else
                Dim intPosColon As Integer = strLine.IndexOf(":")
                Dim strProperty As String = strLine.Substring(0, intPosColon)
                Dim strvalue As String = strLine.Substring(intPosColon + 1).Trim()

                If strProperty = "Store Name" Then

                    strQuery = "insert into receipts (store_name,receipt_number) values('" & strvalue & "','" & num & "')"
                    'MessageBox.Show(strQuery)
                    SQLCMD = New MySqlCommand(strQuery, dbCon)
                    Try
                        SQLCMD.ExecuteNonQuery()
                    Catch ex As Exception
                        MsgBox(ex.Message)
                    End Try
                    MessageBox.Show(strvalue)


                ElseIf strProperty = "Purchase Date" Then
                    strQuery = "update receipts set purchase_date = '" & strvalue & "' where purchase_date IS NULL "
                    'MessageBox.Show(strQuery)
                    SQLCMD = New MySqlCommand(strQuery, dbCon)
                    Try
                        SQLCMD.ExecuteNonQuery()
                    Catch ex As Exception
                        MsgBox(ex.Message)
                    End Try

                    MessageBox.Show(strvalue)

                Else
                    strQuery = "insert into items (item_name,item_price,receipt_number) values('" & strProperty & "','" & CDec(strvalue) & "','" & num & "')"
                    'MessageBox.Show(strQuery)
                    SQLCMD = New MySqlCommand(strQuery, dbCon)
                    Try
                        SQLCMD.ExecuteNonQuery()
                    Catch ex As Exception
                        MsgBox(ex.Message)
                    End Try

                End If
            End If
        Loop

        closeConnection()
    End Sub

    Private Sub openConnection()
        Try
            dbCon = New MySqlConnection("Server=localhost;Database=test;Uid=greg;Pwd=mookieee34")
            dbCon.Open()
        Catch ex As Exception
            MsgBox("Can't connect to the database " & vbCrLf & ex.Message)
        End Try
    End Sub

    Private Sub closeConnection()
        Try
            dbCon.Close()
        Catch ex As Exception
            MsgBox("Can't close the database connection" & vbCrLf & ex.Message)
        End Try
    End Sub

    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        Try
            dbCon = New MySqlConnection("Server=localhost; Database = test; Uid = greg; Pwd = mookieee34")
            strQuery = "select items.receipt_number from items, receipts where items.receipt_number = receipts.receipt_number and item_name = '" & TextBox1.Text & "' and purchase_date>='" & TextBox5.Text & "' and purchase_date<='" & TextBox6.Text & "'"
            dbCon.Open()

            Dim da As MySqlDataAdapter = New MySqlDataAdapter(strQuery, dbCon)

            Dim table As New DataTable
            da.Fill(table)

            DataGridView1.DataSource = table
            dbCon.Close()

        Catch ex As Exception
            MessageBox.Show("Cant talk to the database " & vbCrLf & ex.Message)
        End Try
    End Sub

    Private Sub DataGridView1_CellContentClick(ByVal sender As System.Object, ByVal e As System.Windows.Forms.DataGridViewCellEventArgs) Handles DataGridView1.CellContentClick

    End Sub

    Private Sub Button2_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button2.Click
        Try
            dbCon = New MySqlConnection("Server=localhost; Database = test; Uid = greg; Pwd = mookieee34")
            strQuery = "select store_name from items, receipts where items.receipt_number = receipts.receipt_number And item_name = '" & TextBox7.Text & "'"
            dbCon.Open()

            Dim da As MySqlDataAdapter = New MySqlDataAdapter(strQuery, dbCon)

            Dim table As New DataTable
            da.Fill(table)

            DataGridView1.DataSource = table
            dbCon.Close()

        Catch ex As Exception
            MessageBox.Show("Cant talk to the database " & vbCrLf & ex.Message)
        End Try
    End Sub

    Private Sub Button3_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button3.Click
        Try
            dbCon = New MySqlConnection("Server=localhost; Database = test; Uid = greg; Pwd = mookieee34")
            strQuery = "select purchase_date from items, receipts where items.receipt_number = receipts.receipt_number and item_name = '" & TextBox2.Text & "'"
            dbCon.Open()

            Dim da As MySqlDataAdapter = New MySqlDataAdapter(strQuery, dbCon)

            Dim table As New DataTable
            da.Fill(table)

            DataGridView1.DataSource = table
            dbCon.Close()

        Catch ex As Exception
            MessageBox.Show("Cant talk to the database " & vbCrLf & ex.Message)
        End Try
    End Sub

    Private Sub Button4_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button4.Click
        Try
            dbCon = New MySqlConnection("Server=localhost; Database = test; Uid = greg; Pwd = mookieee34")
            strQuery = "select item_name, store_name from items,receipts where items.receipt_number = receipts.receipt_number and purchase_date >= '" & TextBox8.Text & "' and purchase_date <= '" & TextBox9.Text & "'"
            dbCon.Open()

            Dim da As MySqlDataAdapter = New MySqlDataAdapter(strQuery, dbCon)

            Dim table As New DataTable
            da.Fill(table)

            DataGridView1.DataSource = table
            dbCon.Close()

        Catch ex As Exception
            MessageBox.Show("Cant talk to the database " & vbCrLf & ex.Message)
        End Try
    End Sub

    Private Sub Button5_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button5.Click
        Try
            dbCon = New MySqlConnection("Server=localhost; Database = test; Uid = greg; Pwd = mookieee34")
            strQuery = "select sum(item_price) from items, receipts where items.receipt_number = receipts.receipt_number  and store_name = '" & TextBox4.Text & "'"
            dbCon.Open()

            Dim da As MySqlDataAdapter = New MySqlDataAdapter(strQuery, dbCon)

            Dim table As New DataTable
            da.Fill(table)

            DataGridView1.DataSource = table
            dbCon.Close()

        Catch ex As Exception
            MessageBox.Show("Cant talk to the database " & vbCrLf & ex.Message)
        End Try
    End Sub

    Private Sub Button6_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button6.Click
        Try
            dbCon = New MySqlConnection("Server=localhost; Database = test; Uid = greg; Pwd = mookieee34")
            strQuery = "select store_name from items, receipts where items.receipt_number = receipts.receipt_number and item_name = '" & TextBox3.Text & "' and item_price in(select min(item_price) from items,receipts where items.receipt_number = receipts.receipt_number and item_name = '" & TextBox3.Text & "')"
            dbCon.Open()

            Dim da As MySqlDataAdapter = New MySqlDataAdapter(strQuery, dbCon)

            Dim table As New DataTable
            da.Fill(table)

            DataGridView1.DataSource = table
            dbCon.Close()

        Catch ex As Exception
            MessageBox.Show("Cant talk to the database " & vbCrLf & ex.Message)
        End Try
    End Sub

    Private Sub Label1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Label1.Click

    End Sub

    Private Sub TextBox1_TextChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles TextBox1.TextChanged

    End Sub

    Private Sub TextBox4_TextChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles TextBox4.TextChanged

    End Sub
End Class
