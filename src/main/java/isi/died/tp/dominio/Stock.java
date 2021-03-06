package isi.died.tp.dominio;

public class Stock {
	
	private Integer id;
	private Integer cantidad;
	private Integer puntoPedido;
	private Insumo insumo;
	
	public Stock(int id, int cantidad, int puntoPedido, Insumo insumo) {
		this.cantidad = cantidad;
		this.id = id;
		this.puntoPedido = puntoPedido;
		this.insumo = insumo;
		insumo.agregarStock(this);
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Integer getPuntoPedido() {
		return puntoPedido;
	}
	public void setPuntoPedido(Integer puntoPedido) {
		this.puntoPedido = puntoPedido;
	}
	public Insumo getInsumo() {
		return insumo;
	}
	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
		insumo.agregarStock(this);
	}
	
}
