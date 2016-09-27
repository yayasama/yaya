<?php

namespace App\Model;

use Illuminate\Database\Eloquent\Model;
use DB;

class Category extends Model
{
    protected $table = 'category';

    protected $fillable = [
        'name'
    ];


    public function getByName($name = '')
    {
        $categories = DB::table($this->table)
            ->where('name', $name)
            ->get();

        return $categories ?: [];
    }


}
