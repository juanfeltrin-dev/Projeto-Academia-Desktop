package controller;

import java.util.ArrayList;

import model.bo.TurmaBO;
import model.vo.TurmaVO;



public class TurmaController {
	private TurmaBO bo = new TurmaBO();
	
	 public ArrayList<TurmaVO> consultarTodasTurmas() {
			return bo.consultarTodasTurmas();
		}
}
