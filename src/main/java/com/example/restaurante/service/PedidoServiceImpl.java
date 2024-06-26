package com.example.restaurante.service;

import com.example.restaurante.dtos.PedidoCreateDTO;
import com.example.restaurante.dtos.PedidoDTO;
import com.example.restaurante.dtos.PedidoUpdateDTO;
import com.example.restaurante.mappers.PedidoMapper;
import com.example.restaurante.model.Pedido;
import com.example.restaurante.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService{


    private final PedidoRepository pedidoRepository;

    public PedidoServiceImpl(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public List<PedidoDTO> listarPedidos() {
        return PedidoMapper.instancia.listaPedidoAListaPedidoDTO(pedidoRepository.findAll());
    }

    @Override
    public PedidoDTO obtenerPedidoPorId(Integer id) {
        Optional<Pedido> pedido=pedidoRepository.findById(id);
        return pedido.map(PedidoMapper.instancia::pedidoAPedidoDTO).orElse(null);
    }

    @Override
    public PedidoDTO registrarPedido(PedidoCreateDTO pedidoCreateDTO) {
        Pedido pedido=PedidoMapper.instancia.pedidoCreateDTOAPedido(pedidoCreateDTO);
        pedido.getDetallePedido().forEach(
                det -> {
                    det.setPedido(pedido);
                    det.setTotal(det.getCantidad()*det.getPrecio());
                }
        );
        pedido.setTotal(pedido.getTotal());
        Pedido respuestaEntity=pedidoRepository.save(pedido);
        return PedidoMapper.instancia.pedidoAPedidoDTO(respuestaEntity);
    }

    @Override
    public PedidoDTO actualizarPedido(PedidoUpdateDTO pedidoUpdateDTO) {
        Pedido pedido=PedidoMapper.instancia.pedidoUpdateDTOAPedido(pedidoUpdateDTO);
        Pedido respuestaEntity=pedidoRepository.save(pedido);
        return PedidoMapper.instancia.pedidoAPedidoDTO(respuestaEntity);
    }

    @Override
    public String eliminarPedido(Integer id) {
        Optional<Pedido> pedidoOptional=pedidoRepository.findById(id);
        if (pedidoOptional.isPresent()){
            pedidoRepository.delete(pedidoOptional.get());
            return "Registro Eliminado";
        }else {
            return "No se pudo eliminar";
        }
    }
}
