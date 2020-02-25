import {Component, OnInit} from '@angular/core';
import {GoodsBlueprintModel} from '../../models/goods-blueprint.model';
import {GoodsBlueprintService} from '../../services/goods-blueprint.service';

@Component({
  selector: 'app-goods-blueprint-list',
  templateUrl: './goods-blueprint-list.component.html',
  styleUrls: ['./goods-blueprint-list.component.css']
})
export class GoodsBlueprintListComponent implements OnInit {
  goodsBlueprints: GoodsBlueprintModel[];

  constructor(private goodsBlueprintService: GoodsBlueprintService) { }

  ngOnInit() {
    this.goodsBlueprintService.getAll();
    this.goodsBlueprintService.goodsBlueprintList.subscribe( goodsBlueprints => {
      this.goodsBlueprints = goodsBlueprints;
    });
  }

  selectGoodsBlueprint(index: number) {
    this.goodsBlueprintService.select(this.goodsBlueprints[index]);
  }
}
