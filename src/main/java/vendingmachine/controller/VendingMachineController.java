package vendingmachine.controller;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.exception.dto.ErrorResponse;
import vendingmachine.message.Message;
import vendingmachine.message.dto.ResponseMessage;
import vendingmachine.service.VendingMachineService;

public class VendingMachineController {

	private VendingMachineService vendingMachineService;

	public VendingMachineController() {
		this.vendingMachineService = new VendingMachineService();
	}

	public void postVendingMachineCosts() {
		ResponseMessage.of(Message.ENTER_COSTS_GOING_TO_HAS_MACHINE.getMessage());

		try{
			ResponseMessage.of('\n'+vendingMachineService.postVendingMachineCosts(Console.readLine()));
		} catch(IllegalArgumentException e){
			ErrorResponse.of(e.getMessage());
			postVendingMachineCosts();
		}
	}

	public void postProductInfo(){
		ResponseMessage.of(Message.ENTER_PRODUCT.getMessage());

		try{
			vendingMachineService.postProductInfo(Console.readLine());
		} catch (IllegalArgumentException e){
			ErrorResponse.of(e.getMessage());
			postProductInfo();
		}
	}

	public void postInputCosts(){
		ResponseMessage.of('\n'+Message.ENTER_INPUT_COSTS.getMessage());

		try{
			ResponseMessage.of('\n'+Message.PRINT_INPUT_COSTS.getMessage()+vendingMachineService.postInputCosts(Console.readLine()));
		}catch (IllegalArgumentException e){
			ErrorResponse.of(e.getMessage());
			postInputCosts();
		}
	}

	public void postProductName(){
	}

	public void getBalance(){

	}
}
