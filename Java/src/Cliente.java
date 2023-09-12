class Cliente {
    private String name;

    public Cliente(String _name) {
        this.name = _name;
        Log.getInstance().log("Cliente criado: " + _name);
    }

    public String getName() {
        return name;
    }
}