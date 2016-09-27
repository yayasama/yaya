<?php

namespace App\Http\Controllers\Record;

use App\Http\Controllers\Controller;
use App\Model\Record;
use App\Services\Record\RecordService;
use App\Util\JsonUtil;
use Illuminate\Http\Request;
use Psy\Util\Json;

class RecordController extends Controller
{

    protected $recordService;

    /**
     * RecordController constructor.
     * @param $recordService
     */
    public function __construct(RecordService $recordService)
    {
        $this->recordService = $recordService;
    }


    /**
     * 返回当前登录用户的所有消费记录
     *
     * @return Json
     */
    public function index()
    {
        $userID = session('user')['id'];
        $records = $this->recordService->getRecords($userID);
        exit(JsonUtil::toJson(0, $records));
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        //
    }

    /**
     * 新增一条消费记录
     *
     * @param  Request $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        $record = new Record;

        $record->user = session('user')['id'];
        $record->content = $request->get('content');
        $record->amount = $request->get('amount');
        $record->type = $request->get('type');
        $record->date = $request->get('date');
        $record->location = $request->get('location');
        $record->category = $request->get('category');

        if($this->recordService->save($record)){
            return JsonUtil::toJson(0);
        }else{
            return JsonUtil::toJson(4);
        }
    }

    /**
     * Display the specified resource.
     *
     * @param  int $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        //
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  int $id
     * @return \Illuminate\Http\Response
     */
    public function edit($id)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request $request
     * @param  int $id
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, $id)
    {
        //
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        //
    }
}
