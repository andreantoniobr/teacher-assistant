package controller;

import data.FileIO;

public class Applicantion {
    public final static FileIO fileIO = new FileIO();
    public final static ControladorAluno ControladorAluno = new ControladorAluno();
    public final static ControladorTurma ControladorTurma = new ControladorTurma();
    public final static ControladorPeriodo controladorPeriodo = new ControladorPeriodo();
    public final static ControlladorMetodologiaNota controlladorMetodologiaNota = new ControlladorMetodologiaNota();
    public final static ControladorMetodoAvaliativo controladorMetodoAvaliativo = new ControladorMetodoAvaliativo();
}
