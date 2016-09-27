<?php

namespace App\Services\Record;


use App\Model\Record;
use App\Services\Service;

class RecordService extends Service
{

    protected $record;

    /**
     * RecordService constructor.
     * @param $record
     */
    public function __construct(Record $record)
    {
        $this->record = $record;
    }


    /**
     * 获取用户所有消费记录
     *
     * @param int $userID
     * @return mixed
     */
    public function getRecords($userID = 0)
    {
        return $this->record->getAll($userID);
    }


    /**
     * 新增一条消费记录
     *
     * @param Record $records
     * @return bool
     */
    public function save(Record $records)
    {
        return $records->save();
    }

}