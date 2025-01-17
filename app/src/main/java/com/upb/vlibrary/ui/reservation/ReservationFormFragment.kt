package com.upb.vlibrary.ui.reservation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.upb.vlibrary.Books
import com.upb.vlibrary.databinding.FragmentReservationDetailsBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlin.properties.Delegates

class ReservationFormFragment: Fragment() {

    private lateinit var username:String
    private lateinit var password:String
    private lateinit var libro: Books
    private var idUsuario by Delegates.notNull<Int>()
    private val args: ReservationFormFragmentArgs by navArgs()
    private lateinit var binding: FragmentReservationDetailsBinding
    private val reservationViewModel: ReservationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentReservationDetailsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        username=args.userName
        password=args.password
        libro=args.bookInfo
        idUsuario=args.idUsuario
        binding.librosReserva=libro
        binding.imgConfirmarReservation.setOnClickListener {
            if(password == binding.edtxPassword.text.toString()){
                val fechaReserva = binding.edtxReservationDate.text.toString()
                val fechaDevolucion =binding.edtxFechaDevolucion.text.toString()
                reservationViewModel.reservation(idUsuario,libro.Id_libro,fechaReserva,fechaDevolucion).onEach {
                    val goToSuccessPage= ReservationFormFragmentDirections.actionReservationFormFragmentToReservationSuccessFragment(username,password,idUsuario)
                    findNavController().navigate(goToSuccessPage)
                }.catch {
                    Toast.makeText(context,"Hubo un error con la reservacion", Toast.LENGTH_SHORT).show()
                }.launchIn(CoroutineScope(Dispatchers.Main))
            }else{
                Toast.makeText(context,"Contraseña invalida",Toast.LENGTH_SHORT).show()
            }
        }



    }
}