<?php

namespace App\Http\Controllers\Common;

use App\Http\Controllers\Controller;
use App\Services\ToDoList\ToDoListService;

class IndexController extends Controller
{

    protected $toDoListService;

    /**
     * IndexController constructor.
     * @param $toDoListService
     */
    public function __construct(ToDoListService $toDoListService)
    {
        $this->toDoListService = $toDoListService;
    }


    public function index()
    {
        $saleNumGrey = [123, 234, 345, 456, 567, 678, 789];
        $saleNumBlue = [987, 876, 765, 654, 543, 432, 321];
        $userID = session('user.id');
        $toDoList = $this->toDoListService->getAll($userID);
        return view('index',
            [
                'saleNumGrey' => $saleNumGrey,
                'saleNumBlue' => $saleNumBlue,
                'toDoList' => $toDoList ?: []
            ]
        );
    }

}